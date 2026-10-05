import { Students } from './../../Models/students';
import { Component, OnInit, signal, Signal } from '@angular/core';
import { StudentsService } from '../../Core/Services/students-service';

@Component({
  selector: 'app-all-students',
  imports: [],
  templateUrl: './all-students.html',
  styleUrl: './all-students.css',
})
export class AllStudents implements OnInit{
  constructor(private studentsService:StudentsService){};
  students = signal<Students[]>([]);
  loading = signal(true);
  error = signal('');
  ngOnInit(): void {
    this.getAllStudents();
  }

  getAllStudents(){
    this.loading.set(true);
    this.error.set('');
    this.studentsService.getAll().subscribe({
      next: data => {
        this.students.set(data)
        this.loading.set(false)
      },
      error: err => {
        this.loading.set(false)
        this.error.set('Failed to load Students');
      }
    });
  }

  deleteStudent(id?:number){
    const conf = confirm('Are you sure you want to delete this student?');
    if(!conf){
      return;
    }
    this.studentsService.delete(id).subscribe({
      next: () => {
        alert("Student Deleted Successfully");
        this.getAllStudents();
      },
      error: (err) => {
        alert(`Error : (     ${err}     )`);
      }
    })
  }
}
