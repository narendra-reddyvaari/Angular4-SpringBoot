import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, RequestMethod } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/of';
import { ITask } from './ITask';
@Injectable()
export class TaskService {

  private baseUrl = 'http://localhost:8080/taskmanagement/todo';

  constructor(private http: Http) { }

  getTasks(): Observable<ITask[]> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.get(this.baseUrl, options)
      .map(res => res.json() as Observable<ITask[]>)
      .catch(this.handleErrorObservable);
  }

  handleErrorObservable(error: Response | any) {
    alert("error happened observable");
    alert(error.message);
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

  saveTask(task: ITask): Observable<ITask> {

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ method: RequestMethod.Post, headers: headers });
    return this.http.post(this.baseUrl, task, options)
      .map(res => res.json() as Observable<ITask>)
      .catch(this.handleErrorObservable);
  }

  updateTask(task: ITask): Observable<ITask> {

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ method: RequestMethod.Put, headers: headers });
    return this.http.put(this.baseUrl, task, options)
      .map(res => res.json() as Observable<ITask>)
      .catch(this.handleErrorObservable);
  }

}