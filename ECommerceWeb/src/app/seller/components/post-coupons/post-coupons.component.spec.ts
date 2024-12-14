import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostCouponsComponent } from './post-coupons.component';

describe('PostCouponsComponent', () => {
  let component: PostCouponsComponent;
  let fixture: ComponentFixture<PostCouponsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PostCouponsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PostCouponsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
