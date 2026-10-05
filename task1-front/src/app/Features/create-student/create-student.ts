import { Component, inject, Inject } from '@angular/core';
import { StudentsService } from '../../Core/Services/students-service';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Students } from '../../Models/students';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  imports: [ReactiveFormsModule],
  templateUrl: './create-student.html',
  styleUrl: './create-student.css',
})
export class CreateStudent {
  formBuilder = inject(FormBuilder);
  studentsService = inject(StudentsService);
  router = inject (Router);
  form = this.formBuilder.nonNullable.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
  });

  submit() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      alert("Please Fill All Required Failds")
      return;
    }
    const student: Students = this.form.getRawValue();
    this.studentsService.create(student).subscribe({
      next: () => {
        this.form.reset();
        alert('Student Created Successfully');
      },
    });
  }
}
