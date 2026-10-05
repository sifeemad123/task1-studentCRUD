import { Students } from './../../Models/students';
import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class StudentsService {
private baseURL = "http://localhost:8080/API/students";
constructor(private http:HttpClient) {};

  getAll(): Observable<Students[]> {
    return this.http.get<Students[]>(this.baseURL);
  }

  create( student: Students): Observable<void>{
    return this.http.post<void>(this.baseURL, student);
  }

  delete(id?:number): Observable<void>{
    return this.http.delete<void>(`${this.baseURL}/${id}`);
  }

  update(id:number, student:Students): Observable<void>{
    return this.http.put<void>(`${this.baseURL}/${id}`, student);
  }
}
