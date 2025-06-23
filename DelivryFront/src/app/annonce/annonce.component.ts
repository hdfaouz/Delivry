import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {TrajetService} from "../trajet.service";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-annonce',
  standalone: true,
  imports: [
    MatFormField,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
    ReactiveFormsModule,
    MatInput,
    MatButton,
    MatLabel
  ],
  templateUrl: './annonce.component.html',
  styleUrl: './annonce.component.css'
})
export class AnnonceComponent {
  trajetForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private trajetService: TrajetService,
    private router: Router
  ) {
    this.trajetForm = this.fb.group({
      departure: ['', Validators.required],
      destination: ['', Validators.required],
      stops: [''],
      date: ['', Validators.required],
      typeMarchandise: ['', Validators.required],
      dimensionsMax: ['', Validators.required],
      capaciteDispo: ['', [Validators.required, Validators.min(1)]],
    });
  }

  onSubmit() {
    if (this.trajetForm.invalid) return;

    const rawData = this.trajetForm.value;

    // Convert JS Date -> 'yyyy-MM-dd'
    const dateObj: Date = rawData.date;
    const formattedDate = dateObj.toISOString().split('T')[0];

    const payload = {
      lieuDepart: rawData.departure,
      etapeIntermidiaire: rawData.stops,
      destinationFinal: rawData.destination,
      dateDepart: formattedDate,
      typeMarchandise: rawData.typeMarchandise,
      dimensionMax: rawData.dimensionsMax,
      capaciteDespo: rawData.capaciteDispo
    };

    this.trajetService.createTrajet(payload).subscribe({
      next: () => {
        alert('Annonce ajoutée avec succès');

        this.router.navigate(['/driver/trips']);
      },
      error: (err) => {
        console.error('Erreur:', err);
        alert('Erreur lors de l\'ajout');
      },
    });
  }

}

