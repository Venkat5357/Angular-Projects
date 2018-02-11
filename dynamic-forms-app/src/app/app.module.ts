import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {NullCheckService} from './services/NullCheckService';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [NullCheckService],
  bootstrap: [AppComponent]
})
export class AppModule { }
