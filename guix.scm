(use-modules
 (guix packages)
 ((guix licenses) #:prefix license:)
 (guix download)
 (guix build-system gnu)
 (gnu packages)
 (gnu packages autotools)
 (gnu packages pkg-config)
 (gnu packages texinfo)
 (gnu packages guile)
 (gnu packages java)
 (guix gexp))

(package
  (name "codechallenge-solutions")
  (version "0.0.1")
  (source (local-file (string-append "./"
                                     name
                                     "-"
                                     version
                                     ".tar.bz2")))
  (build-system gnu-build-system)
  (arguments
   `(#:tests? #f))
  (native-inputs (list autoconf automake pkg-config texinfo `(,openjdk17 "jdk") ))
  (inputs (list guile-3.0-latest))
  (synopsis "Toy Repository for Code Challenge Solutions.")
  (description
   (string-append
    "Mostly just a repository of my solutions to various coding challenges, "
    "but also any tools I make along the way."))
  (home-page
   "https://github.com/yewscion/codechallenge-solutions")
  (license license:agpl3+))
