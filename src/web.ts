import { WebPlugin } from '@capacitor/core';

import type { ForegroundServicePlugin } from './definitions';

export class ForegroundServiceWeb extends WebPlugin implements ForegroundServicePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
