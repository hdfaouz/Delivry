import {Component, OnInit} from '@angular/core';
import {TrajetService} from "../trajet.service";
import {MatCard} from "@angular/material/card";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-list-annonces',
  standalone: true,
  imports: [
    MatCard,
    DatePipe
  ],
  templateUrl: './list-annonces.component.html',
  styleUrl: './list-annonces.component.css'
})
export class ListAnnoncesComponent implements OnInit{
  trajets: any[] = [];


  constructor(private trajetService: TrajetService) {}

  ngOnInit(): void {
    this.trajetService.getAll().subscribe({
      next: (data) => {
        this.trajets = data;

      },
      error: (err) => {
        console.error('Erreur lors du chargement des trajets:', err);
      }
    });
  }

}
