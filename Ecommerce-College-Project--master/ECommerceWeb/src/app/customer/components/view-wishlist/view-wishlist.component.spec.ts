import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewWishlistComponent } from './view-wishlist.component';

describe('ViewWishlistComponent', () => {
  let component: ViewWishlistComponent;
  let fixture: ComponentFixture<ViewWishlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewWishlistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewWishlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
