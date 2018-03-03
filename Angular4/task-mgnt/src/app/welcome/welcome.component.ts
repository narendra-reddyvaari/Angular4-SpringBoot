import { Component, OnInit } from '@angular/core';
import { ITask } from '../ITask';
import { TaskService } from '../task.service';

@Component({
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  errorMessage: string;
  tasks: ITask[];

  description: string;
  
  constructor(private taskService: TaskService) { }

  ngOnInit() {

    this.taskService.getTasks()
      .subscribe(resulttasks => this.tasks = resulttasks,
        error => this.errorMessage = <any>error);
  }

  addTask(): void {

    let task = this.getInitizedTask();
    this.taskService.saveTask(task)
      .subscribe(
        (newTask) =>{
          this.tasks.push(newTask);
          this.onSaveComplete()},
        (error: any) => this.errorMessage = <any>error
      ); 

  }

  onSaveComplete(): void {
    // Reset the input
    this.description='';
  }

  private getInitizedTask(): ITask{
    let r = {
      "id": -1,
      "description": this.description,
      "completed": false
    }
    return r;
  }
}
