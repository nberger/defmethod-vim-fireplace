# defmethod-vim-fireplace

Used to reproduce an issue in vim-fireplace that manifests when the current
buffer has a `(defmethod clojure.test/report :something ...)` form and `cpr`
is executed: An exception as the following is thrown:

```
java.lang.ClassCastException: defmethod_vim_fireplace.core_test$eval3669$fn__3670
                              cannot be cast to clojure.lang.MultiFn,
                              compiling:(defmethod_vim_fireplace/core_test.clj:5:1)
```

This is because vim-fireplace [rebinds](https://github.com/tpope/vim-fireplace/blob/233f023cdde372e1124b77940a30cb0eb6d06a13/plugin/fireplace.vim#L1653-L1670)
clojure.test/report to a new function that is not a multimethod and reloads the
current ns inside of that binding (before running the tests), so the defmethod
fails.


## Usage

Start the REPL, open `test/defmethod_vim_fireplace/core_test.clj` in vim with
vim-fireplace and type `cpr`

## License

Copyright © 2016 Nicolás Berger

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
