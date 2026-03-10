import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Fighter } from "./models/fighter";

@Injectable({
  providedIn: "root",
})
export class FighterService {

  constructor(private http: HttpClient) { }

  searchFighters(query: string) {
    return this.http.get<Fighter[]>(`/api/fighters/search?name=${query}`);
  };
}