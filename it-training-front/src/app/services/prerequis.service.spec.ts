import { TestBed } from '@angular/core/testing';

import { PrerequisService } from './prerequis.service';

describe('PrerequisService', () => {
  let service: PrerequisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrerequisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
