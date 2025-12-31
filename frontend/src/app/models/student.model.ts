export interface Student {
  id?: number;  // ? means optional (when creating new student, no ID yet)
  firstName: string;
  lastName: string;
  email: string;
  studentNumber: string;
}