import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UniversityService } from '../../../services/university.service';
import { Student } from '../../../models/student.model';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit {
  
  students: Student[] = [];  // Array to hold students
  loading = true;
  error = '';

  constructor(private universityService: UniversityService) { }

  ngOnInit(): void {
    // This runs when component loads (like @PostConstruct in Spring)
    this.loadStudents();
  }

  loadStudents(): void {
    this.universityService.getAllStudents().subscribe({
      next: (data) => {
        this.students = data;  // Save students to array
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load students';
        this.loading = false;
        console.error(err);
      }
    });
  }
}