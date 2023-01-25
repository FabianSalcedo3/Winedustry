new Vue({
  el: "#app",
  data() {
    return {
      currentCardBackground: Math.floor(Math.random()* 25 + 1), // just for fun :D
      cardName: "",
      cardNumber: "",
      cardMonth: "",
      cardYear: "",
      cardCvv: "",
      minCardYear: new Date().getFullYear(),
      amexCardMask: "#### ###### #####",
      otherCardMask: "#### #### #### ####",
      cardNumberTemp: "",
      isCardFlipped: false,
      focusElementStyle: null,
      isInputFocused: false
    };
  },
  mounted() {
    this.cardNumberTemp = this.otherCardMask;
    document.getElementById("cardNumber").focus();
  },
  computed: {
    getCardType () {
      let number = this.cardNumber;
      let re = new RegExp("^4");
      if (number.match(re) != null) return "visa";

      re = new RegExp("^(34|37)");
      if (number.match(re) != null) return "amex";

      re = new RegExp("^5[1-5]");
      if (number.match(re) != null) return "mastercard";

      re = new RegExp("^6011");
      if (number.match(re) != null) return "discover";
      
      re = new RegExp('^9792')
      if (number.match(re) != null) return 'troy'

      return "visa"; // default type
    },
		generateCardNumberMask () {
			return this.getCardType === "amex" ? this.amexCardMask : this.otherCardMask;
    },
    minCardMonth () {
      if (this.cardYear === this.minCardYear) return new Date().getMonth() + 1;
      return 1;
    }
  },
  watch: {
    cardYear () {
      if (this.cardMonth < this.minCardMonth) {
        this.cardMonth = "";
      }
    }
  },
  methods: {
    flipCard (status) {
      this.isCardFlipped = status;
    },
    focusInput (e) {
      this.isInputFocused = true;
      let targetRef = e.target.dataset.ref;
      let target = this.$refs[targetRef];
      this.focusElementStyle = {
        width: `${target.offsetWidth}px`,
        height: `${target.offsetHeight}px`,
        transform: `translateX(${target.offsetLeft}px) translateY(${target.offsetTop}px)`
      }
    },
    blurInput() {
      let vm = this;
      setTimeout(() => {
        if (!vm.isInputFocused) {
          vm.focusElementStyle = null;
        }
      }, 300);
      vm.isInputFocused = false;
    }
  }
});






// BOTTONE ANIMATO

document.querySelectorAll('.truck-button').forEach(button => {
  button.addEventListener('click', e => {

      e.preventDefault();
      
      let box = button.querySelector('.box'),
          truck = button.querySelector('.truck');
      
      if(!button.classList.contains('done')) {
          
          if(!button.classList.contains('animation')) {

              button.classList.add('animation');

              gsap.to(button, {
                  '--box-s': 1,
                  '--box-o': 1,
                  duration: .3,
                  delay: .5
              });

              gsap.to(box, {
                  x: 0,
                  duration: .4,
                  delay: .7
              });

              gsap.to(button, {
                  '--hx': -5,
                  '--bx': 50,
                  duration: .18,
                  delay: .92
              });

              gsap.to(box, {
                  y: 0,
                  duration: .1,
                  delay: 1.15
              });

              gsap.set(button, {
                  '--truck-y': 0,
                  '--truck-y-n': -26
              });

              gsap.to(button, {
                  '--truck-y': 1,
                  '--truck-y-n': -25,
                  duration: .2,
                  delay: 1.25,
                  onComplete() {
                      gsap.timeline({
                          onComplete() {
                              button.classList.add('done');
                          }
                      }).to(truck, {
                          x: 0,
                          duration: .4
                      }).to(truck, {
                          x: 40,
                          duration: 1
                      }).to(truck, {
                          x: 20,
                          duration: .6
                      }).to(truck, {
                          x: 96,
                          duration: .4
                      });
                      gsap.to(button, {
                          '--progress': 1,
                          duration: 2.4,
                          ease: "power2.in"
                      });
                  }
              });
              
          }
          
      } else {
          button.classList.remove('animation', 'done');
          gsap.set(truck, {
              x: 4
          });
          gsap.set(button, {
              '--progress': 0,
              '--hx': 0,
              '--bx': 0,
              '--box-s': .5,
              '--box-o': 0,
              '--truck-y': 0,
              '--truck-y-n': -26
          });
          gsap.set(box, {
              x: -24,
              y: -6
          });
      }

  });
});