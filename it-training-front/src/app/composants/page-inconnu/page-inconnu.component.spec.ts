import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageInconnuComponent } from './page-inconnu.component';

describe('PageInconnuComponent', () => {
  let component: PageInconnuComponent;
  let fixture: ComponentFixture<PageInconnuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageInconnuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageInconnuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
