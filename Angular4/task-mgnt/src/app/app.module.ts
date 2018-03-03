import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { TaskService } from './task.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EdittaskComponent } from './edittask/edittask.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    EdittaskComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot([
      { path: 'welcome', component: WelcomeComponent },
      { path: '', redirectTo: 'welcome', pathMatch: 'full' },
      { path: '**', redirectTo: 'welcome', pathMatch: 'full' }
    ]),
  ],

  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
