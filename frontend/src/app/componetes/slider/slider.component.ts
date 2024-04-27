import { Component, ElementRef, OnInit, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent implements OnInit, AfterViewInit {
  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.startSliders();
  }

  startSliders() {
    const sliders = [
      { selector: '.slide', counter: 0 },
      { selector: '.slide1', counter: 0 },
      { selector: '.slide2', counter: 0 },
      { selector: '.slide3', counter: 0 }
    ];

    sliders.forEach((slider, index) => {
      const slides = document.querySelectorAll(slider.selector);
      const totalSlides = slides.length;

      setInterval(() => {
        slides.forEach((slide: Element) => {
          slide.classList.remove('active');
        });
        slider.counter = (slider.counter + 1) % totalSlides;
        slides[slider.counter].classList.add('active');
      }, 3000);
    });
  }
}
