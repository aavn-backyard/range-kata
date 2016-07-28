# Range kata

~This is part of the Kata series~

## Submit your own solution

- It is **REQUIRED** to have Unit Tests for the solution.
- It is encourage to implement your solution **as Clean Code as possible**.

1. Fork this repo.
2. Add your own Maven project into directory `/solutions`. Name it `range-kata-by-${username}`. Implement your solution there.
3. To submit your solution, create a PR to this repo.

```
/range-kata
  |-README.md
  \-solutions
    |- range-kata-by-AndyHoang
    |- range-kata-by-somebodyelse
```

----

Implement a class `Range` to present a range of elements (having natural order). To create a `Range` instance, simply give it a `lowerbound` and a `upperbound`.

> Note: Do this kata step by step and extend it.

## Numbers

Class `Range` can be used with `int`.

```
Range validAgesForWatchingPorn = Range.of(13, 100);

validAgesForWatchingPorn.contains(5); // false
validAgesForWatchingPorn.contains(22); // true

```

- `Range` must be *immutable*, once created, there is no way to change its `lowerbound` and `upperbound`.
- `Range` must provide a _static factory method_ namely `of(int, int)` to create a new instance.
- It is not allowed to create a `Range` with `lowerbound > upperbound`.
- The method `contains(x)` must returns `true` only if 
`lowerbound <= x <=upperbound`.

## Types of `Range`

Mathmatically, a `Range` can be `open`, `closed`, `openClosed` or `closedOpen`.

```
// open range excludes both bounds
(5, 7)

// closed range includes both bounds
[5, 7]

// open closed excludes lowerbound but includes upperbound
(5, 7]

// closed open includes lowerbound but excludes upperbound
[5, 7)

```


- Extend `Range` such that it can support all of the above types. (This implies the method `of(int,int`) will be renamed to `open(int, it)`)

```
Range open = Range.open(5, 7);
open.contains(5); //false

Range closed = Range.closed(5, 7);
closed.contains(5); // true

Range openClosed = Range.openClosed(5, 7);
openClosed.contains(5); // false
openClosed.contains(7); // true

Range closedOpen = Range.closedOpen(5, 7);
closedOpen.contains(5); // true;
closedOpen.contains(7); // false;

```


## Make it generic with all `Comparable<T>` types

Extends the `Range` such that it can supports any types implementing `Comparable` interface.


```

Range text = Range.open("abc", "xyz");

Range decimals = Range.open(BigDecimal.valueOf("1.32432"), BigDecimal.valueOf("1.324323423423423423423"));

Range dates = Range.closed(LocalDate.of(2016, Month.SEPTEMBER, 11), LocalDate.of(2017, Month.JUNE, 30)));

```

## Make it harder

We want to have `Range` to support an open-ended style with `Infinitive`. For example:

```
Range<Integer> lessThanFive = Range.lessThan(5);
lessThanFive.contains(5); // false;
lessThanFive.contains(-9000); // true;

Range<Integer> atLeastFive = Range.atLeast(5);
atLeastFive.contains(5); // true;
atLeastFive.contains(4); // false;

Range<Integer> atMostFive = Range.atMost(5);
atMostFive.contains(5); // true
atMostFive.contains(-234234); // true;
atMostFive.contains(6); // false;


Range<LocalDate> afterEpoch = Range.greaterThan(LocalDate.of(1900, Month.JANUARY, 1));
afterEpoch.contains(LocalDate.of(2016, Month.JULY, 28)); // true;
afterEpoch.contains(LocalDate.of(1750, Month.JANUARY, 1)); // false;


Range<String> all = Range.all();
all.contains("anything"); // true;
all.contains(""); // true;
all.contains(null); // true;

```