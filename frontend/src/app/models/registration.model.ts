import { Student } from './student.model';
import { Module } from './module.model';

export interface Registration {
  id?: number;
  student: Student;
  module: Module;
  mark?: number;
  semester: string;
}