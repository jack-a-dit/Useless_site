import { TestBed } from '@angular/core/testing';
import { Interface } from './interface';

describe('Interface', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Interface],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(Interface);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should render title', async () => {
    const fixture = TestBed.createComponent(Interface);
    await fixture.whenStable();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, ui');
  });
});
