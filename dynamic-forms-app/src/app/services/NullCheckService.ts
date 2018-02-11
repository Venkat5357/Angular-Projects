import {Injectable} from '@angular/core';
import * as objectPath from 'object-path';

@Injectable()
export class NullCheckService {
  public static fetchFromPath(obj: Object, path: string): any {
    if (objectPath.has(obj, path)) {
      return objectPath.get(obj, path);
    } else {
      return undefined;
    }
  }
}
