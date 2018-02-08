import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Business} from '../business/business'

const URL_API = 'http://localhost:8080';

@Injectable()
export class BusinessService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  public getAllBusinesses<T>() {

    this.httpClient.get(URL_API + '/businesses', {observe: 'response'})
      .subscribe(resp => {
         return resp.body;
        }
      )
  }

  // public createTodo(todo: Todo): Observable<Todo> {
  //   return this.http
  //     .post(API_URL + '/todos', todo)
  //     .map(response => {
  //       return new Todo(response.json());
  //     })
  //     .catch(this.handleError);
  // }
  //
  // public getTodoById(todoId: number): Observable<Todo> {
  //   return this.http
  //     .get(API_URL + '/todos/' + todoId)
  //     .map(response => {
  //       return new Todo(response.json());
  //     })
  //     .catch(this.handleError);
  // }
  //
  // public updateTodo(todo: Todo): Observable<Todo> {
  //   return this.http
  //     .put(API_URL + '/todos/' + todo.id, todo)
  //     .map(response => {
  //       return new Todo(response.json());
  //     })
  //     .catch(this.handleError);
  // }
  //
  // public deleteTodoById(todoId: number): Observable<null> {
  //   return this.http
  //     .delete(API_URL + '/todos/' + todoId)
  //     .map(response => null)
  //     .catch(this.handleError);
  // }
  //
  // private handleError (error: Response | any) {
  //   console.error('ApiService::handleError', error);
  //   return Observable.throw(error);
  // }
}
