import { TestBed } from '@angular/core/testing';

import { DataserveService } from './dataserve.service';

describe('DataserveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DataserveService = TestBed.get(DataserveService);
    expect(service).toBeTruthy();
  });
});
