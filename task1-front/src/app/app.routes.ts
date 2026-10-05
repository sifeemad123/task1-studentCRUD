import { Routes } from '@angular/router';
import { Home } from './Features/home/home';
import { CreateStudent } from './Features/create-student/create-student';
import { AllStudents } from './Features/all-students/all-students';
import { UpdateStudent } from './Features/update-student/update-student';

export const routes: Routes = [
    {
        component: Home,
        path: ""
    },
    {
        component: CreateStudent,
        path: "createStudent"
    },
    {
        component: AllStudents,
        path: "allStudents"
    },
    {
        component: UpdateStudent,
        path: "updateStudent"
    }
];
