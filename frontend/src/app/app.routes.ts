import { Routes } from '@angular/router';
import { HomeSection } from './features/home-section/home-section';
import { FindFighter } from './features/fighters/find-fighter/find-fighter';
import { CompareFighters } from './features/fighters/compare-fighters/compare-fighters';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeSection },
  { path: 'find-fighter', component: FindFighter },
  { path: 'compare-fighters', component: CompareFighters },
];
