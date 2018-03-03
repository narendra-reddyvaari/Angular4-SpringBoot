import { Component, OnInit, Input } from '@angular/core';
import { ITask } from '../ITask';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-edittask',
  templateUrl: './edittask.component.html',
  styleUrls: ['./edittask.component.css']
})
export class EdittaskComponent implements OnInit {
  errorMessage: string;
 @Input() private task:ITask;
  constructor(private taskService:TaskService) { }

  ngOnInit() {
  }


   editTask(task:ITask):void{

    this.taskService.updateTask(task)
    .subscribe(
      (uptdTask) =>{
        alert(uptdTask.description);
        this.closeWindow()},
      (error: any) => this.errorMessage = <any>error
    ); 
  } 

  closeWindow():void{

  }
}
