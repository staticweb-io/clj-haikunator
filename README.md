# spec-forms

[![Clojars Project](https://img.shields.io/clojars/v/io.staticweb/clj-haikunator.svg)](https://clojars.org/io.staticweb/clj-haikunator)

A Heroku-like random name generator based on https://github.com/usmanbashir/haikunator.

## Install

Add to deps.edn:
```
io.staticweb/clj-haikunator {:mvn/version "1.0.0"}
```

Or add to project.clj:
```
[io.staticweb/clj-haikunator "1.0.0"]
```

## Usage

```clojure
(use 'clj-haikunator)

(haikunate)
;= "snowy-resonance-8394"
```