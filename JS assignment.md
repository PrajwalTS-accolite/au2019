# JS assignment

1. Refactor code snippet to return the following result

   ```javascript
   console.log(foo.show()); // ["hello world", "hello world"]
   
   var foo = {
      title: 'world',
      show() {
         return ['', ''].map(function(a) { return 'hello ' + this.title });
      }
   };
   ```

   ##### Answer

   ```javascript
   var foo = {
      title: 'world',
      show() {
   	  let word = this.title;
         return ['', ''].map(function(a) { return 'hello ' + word });
      }
   };
   
   console.log(foo.show());
   ```

2. What does the following code print to the console?

   ```javascript
   function foo() {
     var a = 42;
     (function() {
       a = 27;
       console.log(a);
     })();
     console.log(a);
   }
   foo();
   
   ```

   ##### Output

   27

   27 

   undefined

3. Given the following code snippet:

   ```javascript
   let foo = 5;
   function addTwo(foo) {
     foo = foo + 2;
   }
   addTwo(foo);
   console.log(foo);
   ```

   ##### Output

   5

4. How can you return a new function and assign the this context to an object?

   ```javascript
   var module = {
     x: 42,
     getX: function() {
       return this.x;
     }
   }
   ```

   ##### Answer

   ```javascript
   let f1 = module.getX;
   let f2 = f1.bind(module);
   console.log(f2())
   ```

5. The following snippet throws an error. Why?

   ```javascript
   function foo() {
     'use strict';
     (function () {
       var point = {x: 42, y: 27};
       with (point) {
         console.log('The coordinates are: x: ', x, 'y: ', y);
       }
     })();
   }
   foo();
   ```

   ##### Answer

   'With' statement cannot be used in strict mode.

6. What is wrong with this snippet?

   ```javascript
   class MegaArray extends Array{
     constructor(contents){
       this.contents = contents;
     }
   }
   let mArr = new MegaArray(1, 2, 3);
   ```

   ##### Answer

   super constructer must be called in the constructor.

7. What is the correct syntax for accessing the argument object inside a function?

   ##### Answer

   ```javascript
   class MegaArray extends Array{
     constructor(...contents){
   	super();
       this.contents = contents;
     }
   }
   let mArr = new MegaArray(1, 2, 3);
   
   console.log(mArr.contents)
   
   //Output
   //[1, 2, 3]
   ```

8. Print 0 to 9 in sequence by making changes to the following code

   ```javascript
   for (var i = 0; i < 10; i++) {
   	setTimeout(function() 
   	{ 
   		console.log(i); 
   	}, 0);
   }
   ```

   ##### Answer

   ```javascript
   for (var i = 0; i < 10; i++) {
   	(function(i){ 
   		setTimeout(function() 
           { 
   			console.log(i);
           }, 0);
   	})(i);
   }
   ```

## Exercise

#### Instructions

1. Fix the code so it prints out the alphabet A-Z in the console.

2. Cannot:
	- Have **any** global variables at all
	- Delete or combine any function declarations
	- Create any new functions (except IIFEs -- hint!)
	- Rearrange the order of declarations

3. Can/must:
	- Declare extra variables (as long as they're not global)
	- Modify (in-place) function declaration/initialization
	- Add/remove statements/expressions (IIFEs, return, params, etc)
	- Make the fewest changes possible 

```javascript
A();

function C() {
	console.log("OOPS!");
}

function E(f) {
	console.log("E");
	f();
	var f = F;
}

var A = function() {
	console.log("A");
	B();
};

var C;

function G() {
	console.log("G");
	H();

	var H = function() {
		console.log("H");
		I();
	};
}

var D = d;

function d() {
	console.log("D");
	E();
}

function I() {
	console.log("I");
	J();
	J();
}

B = function() {
	console.log("B");
	C();
};

var F = function() {
	console.log("F");
	G();
};

var rest = "KLMNOPQRSTUVWXYZ".split("");
for (var i=0; i<rest.length; i++) {
	(function(i){
		// define the current function
		window[rest[i]] = function() {
			console.log(rest[i]);
			if (i < (rest.length-1)) {
				// TODO: call the next function
			}
		};
	})(i);
}

var J = function() {
	J = function() {
		console.log("J");
		K();
	};
};

C = function() {
	console.log("C");
	D();
};
```

#### Answer

```javascript
function A() {
	console.log("A");
	B();
};

function B() {
	console.log("B");
	C();
};

function C() {
	console.log("C");
	D();
}

function D() {
	console.log("D");
	E();
}

function E() {
	console.log("E");
	F();
}

function F() {
	console.log("F");
	G();
}

function G() {
	console.log("G");
	H();
	function H() {
		console.log("H");
		I();
	}
}

function I() {
	console.log("I");
	J();
}

function J() {
		console.log("J");
		K2Z();
};

function K2Z() {
	let rest = "KLMNOPQRSTUVWXYZ".split("");
	for (var i=0; i<rest.length; i++) {
        (function(i){
                console.log(rest[i]);
        })(i);
	}
}

A();
```

