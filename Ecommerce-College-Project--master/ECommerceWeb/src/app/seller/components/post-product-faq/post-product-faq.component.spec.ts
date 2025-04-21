import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostProductFaqComponent } from './post-product-faq.component';

describe('PostProductFaqComponent', () => {
  let component: PostProductFaqComponent;
  let fixture: ComponentFixture<PostProductFaqComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PostProductFaqComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PostProductFaqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
