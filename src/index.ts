import { registerPlugin } from '@capacitor/core';

import type { ForegroundServicePlugin } from './definitions';

const ForegroundService = registerPlugin<ForegroundServicePlugin>('ForegroundService', {
  web: () => import('./web').then(m => new m.ForegroundServiceWeb()),
});

export * from './definitions';
export { ForegroundService };
