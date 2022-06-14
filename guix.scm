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
                                     ".tar.gz")))
  (build-system gnu-build-system)
  (native-inputs (list autoconf automake pkg-config texinfo))
  (inputs (list guile-3.0-latest openjdk17))
  (synopsis "Toy Repository for Code Challenge Solutions.")
  (description
   (string-append
    "Mostly just a repository of my solutions to various coding challenges, "
    "but also any tools I make along the way."))
  (home-page
   "https://github.com/yewscion/codechallenge-solutions")
  (license license:agpl3+))
