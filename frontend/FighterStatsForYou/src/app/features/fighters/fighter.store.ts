import { Injectable, signal } from "@angular/core";
import { FighterService } from "./fighter.service";
import { Fighter } from "./models/fighter";

@Injectable({
  providedIn: "root",
})
export class FighterStore {
  readonly _fighters = signal<Fighter[]>([]);


  constructor(private fighterService: FighterService) { }

  setFighters(fighters: Fighter[]) {
    this._fighters.set(fighters);
  }

  getFighters() {
    return this._fighters;
  }

  searchFighters(query: string) {
    this.fighterService.searchFighters(query)
      .subscribe({
        next: (fighterList: Fighter[]) => {
          if (fighterList.length === 0) {
            this.setFighters([]);
          } else {
            this.setFighters(fighterList);
          }
        },
        error: () => {
          throw new Error("Failed to search fighters. Please try again later.");
        }
      });
  }
}