/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class',
  content: [
    "./src/**/*.{html,ts,scss}",
  ],
  safelist: [
    'bg-primary',
    'bg-secondary',
    'bg-cardBg',
    'text-primary',
    'text-secondary',
    'text-textMain',
  ],
  theme: {
    extend: {
      colors: {
        primary: 'var(--color-primary)',
        secondary: 'var(--color-secondary)',
        cardBg: 'var(--color-cardBg)',
        textMain: 'var(--color-textMain)',
      },
      fontFamily: {
        mono: ['"JetBrains Mono"', 'monospace'],
      },
    },
  },
  plugins: [],
}