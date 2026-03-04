import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { TopNav } from './layout/top-nav/top-nav';
import { SideNav } from './layout/side-nav-bar/side-nav';
import { HomeSection } from './features/home-section/home-section';
import { FindFighter } from './features/find-fighter/find-fighter';
import { CompareFighters } from './features/compare-fighters/compare-fighters';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TopNav, SideNav],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('FighterStatsForYou');
}
