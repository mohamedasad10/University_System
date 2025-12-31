import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/student.model';
import { Module } from '../models/module.model';
import { Registration } from '../models/registration.model';

@Injectable({
  providedIn: 'root'
})
export class UniversityService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  createStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.apiUrl}/students`, student);
  }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.apiUrl}/students`);
  }

getStudentById(id: number): Observable<Student> {
  return this.http.get<Student>(`${this.apiUrl}/students/${id}`);
}

// ========== MODULE OPERATIONS ==========
createModule(module: Module): Observable<Module> {
  return this.http.post<Module>(`${this.apiUrl}/modules`, module);
}

getAllModules(): Observable<Module[]> {
  return this.http.get<Module[]>(`${this.apiUrl}/modules`);
}

// ========== REGISTRATION OPERATIONS ==========
registerStudent(studentId: number, moduleId: number, semester: string): Observable<Registration> {
  return this.http.post<Registration>(
    `${this.apiUrl}/registrations?studentId=${studentId}&moduleId=${moduleId}&semester=${semester}`,
    {}
  );
}

updateMark(registrationId: number, mark: number): Observable<Registration> {
  return this.http.put<Registration>(
    `${this.apiUrl}/registrations/${registrationId}/mark?mark=${mark}`,
    {}
  );
}

getStudentRegistrations(studentId: number): Observable<Registration[]> {
  return this.http.get<Registration[]>(`${this.apiUrl}/students/${studentId}/registrations`);
}
}