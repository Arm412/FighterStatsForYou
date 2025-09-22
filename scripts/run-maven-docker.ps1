<#
Runs Maven inside a Docker container so you don't need Maven installed locally.
Usage examples (PowerShell):
  # package the java module
  .\scripts\run-maven-docker.ps1 -Args 'package' -Module 'backend/java'

  # run spring-boot:run
  .\scripts\run-maven-docker.ps1 -Args 'spring-boot:run' -Module 'backend/java'
#>
param(
    [string]$Args = 'package',
    [string]$Module = 'backend/java'
)

$RepoRoot = Split-Path -Parent $MyInvocation.MyCommand.Definition
$ModulePath = Join-Path $RepoRoot $Module

if (-not (Test-Path $ModulePath)) {
    Write-Error "Module path not found: $ModulePath"
    exit 1
}

# Convert Windows path to Docker-friendly path if using Docker Desktop (bind-mount expects drive letter path)
$pwdPath = Resolve-Path $RepoRoot
$pwdPathStr = $pwdPath.Path -replace '\\','/'
$pwdPathStr = $pwdPathStr -replace '^([A-Za-z]):','/$1'

$dockerCmd = "docker run --rm -v `"$pwdPathStr`":/workspace -w /workspace/$Module maven:3.9.4-eclipse-temurin-17 mvn $Args"
Write-Output "Running: $dockerCmd"
Invoke-Expression $dockerCmd
