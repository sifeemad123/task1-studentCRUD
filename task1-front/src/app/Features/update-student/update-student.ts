import { Component, inject } from '@angular/core';
import { StudentsService } from '../../Core/Services/students-service';

@Component({
  selector: 'app-update-student',
  imports: [],
  templateUrl: './update-student.html',
  styleUrl: './update-student.css',
})
export class UpdateStudent {
  private studentsService = inject(StudentsService);

}
