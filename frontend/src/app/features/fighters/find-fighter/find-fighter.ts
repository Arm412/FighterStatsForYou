import { Component, SimpleChanges, inject, DestroyRef, effect, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { debounceTime } from 'rxjs';
import { FighterStore } from '../fighter.store';
import { Subject } from 'rxjs';
import { toObservable } from '@angular/core/rxjs-interop';

@Component({
  selector: 'app-find-fighter',
  imports: [FormsModule, CommonModule],
  templateUrl: './find-fighter.html',
  styleUrl: './find-fighter.css',
})
export class FindFighter {
  fighterName = signal('');
  fighterStore = inject(FighterStore);

  private searchSubject = new Subject<string>();
  fighterList = this.fighterStore.getFighters();

  private fighterNameObservable = toObservable(this.fighterName);

  constructor() {
    effect(() => {
      this.fighterNameObservable
        .pipe(debounceTime(1000))
        .subscribe(value => {
          const trimmed = value.trim();

          if (trimmed === '') {
            this.fighterStore.setFighters([]);
            return;
          }

          if (trimmed.length < 2) return;

          this.fighterStore.searchFighters(trimmed);
        });
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log(changes)
    if (changes['fighterName']) {
      console.log('fighterName changed:', changes['fighterName'].currentValue);
    }
  }

  printFighterName = () => {
    console.log('Current fighter name:', this.fighterName);
  }

  onFighterChange(value: string) {
    this.searchSubject.next(value);
  }
}
