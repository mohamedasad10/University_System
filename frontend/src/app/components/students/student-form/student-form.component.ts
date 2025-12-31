import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UniversityService } from '../../../services/university.service';
import { Student } from '../../../models/student.model';

@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [CommonModule, FormsModule],  // FormsModule for ngModel
  templateUrl: './student-form.component.html',
  styleUrl: './student-form.component.css'
})
export class StudentFormComponent {
  
  student: Student = {
    firstName: '',
    lastName: '',
    email: '',
    studentNumber: ''
  };

  successMessage = '';
  errorMessage = '';

  constructor(private universityService: UniversityService) { }

  onSubmit(): void {
    this.successMessage = '';
    this.errorMessage = '';

    this.universityService.createStudent(this.student).subscribe({
      next: (data) => {
        this.successMessage = `Student ${data.firstName} created successfully!`;
        this.resetForm();
      },
      error: (err) => {
        this.errorMessage = 'Failed to create student. Please try again.';
        console.error(err);
      }
    });
  }

  resetForm(): void {
    this.student = {
      firstName: '',
      lastName: '',
      email: '',
      studentNumber: ''
    };
  }
}