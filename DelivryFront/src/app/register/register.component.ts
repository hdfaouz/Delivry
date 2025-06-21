import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import { RouterLink} from "@angular/router";
import { Router } from '@angular/router'; // Correction de l'import ici
import {NgIf} from "@angular/common";
import {AuthService, RegisterRequest} from "../auth.service";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule,
    RouterLink,
    HttpClientModule,
    NgIf],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{
  register:FormGroup;
  loading=false;
  erreur='';
  success='';

  constructor(private form:FormBuilder, private auth:AuthService,private router:Router){
    this.register=this.form.group({
      email:['',[Validators.required]],
      password:['',[Validators.required]],
      role:['',[Validators.required]]
    })
  }

  ngOnInit(): void {
    this.erreur='';
      this.success=''
  }
  onSubmit() {
    if (this.register.valid) {
      console.log(this.register.value);
      const data :  RegisterRequest= this.register.value;
      this.auth.register(data).subscribe({
        next : response =>{
          this.success = 'Registration successful';
          this.erreur = '';
          this.register.reset();
          //pour rediriger après 1,5 second vers login
          setTimeout(()=> this.router.navigate(['/login']),1500);
        },
        error: err=>{
          this.erreur = err || 'Registration failed';
          this.success='';
        }
      });

    }
  }
}
