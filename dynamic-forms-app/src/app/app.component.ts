import { Component } from '@angular/core';
import {NullCheckService} from './services/NullCheckService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  object: { a: {b?: [string]}} = { a: {}};
  selectToDisplay;

  public accessNonExistentPath(): void {
    this.selectToDisplay = this.object.a.b[0];
  }


  public accessNonExistentPathUsingNullCheckService(): void {
    this.selectToDisplay = NullCheckService.fetchFromPath(this.object, `a.b.0`);
  }

}
