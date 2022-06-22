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
   `(#:tests? #f
     #:phases
     (modify-phases
      %standard-phases
      (add-after
       'install 'subjars
       (lambda* (#:key outputs #:allow-other-keys)
         (let* ((out (assoc-ref outputs "out"))
                (bin (string-append out "/bin"))
                (share (string-append out "/share")))
           (substitute*
            (string-append bin
                           "/minimumJumps-java")
            (("/usr/local/share/java/minimumJumps.jar")
             (string-append share
                            "/java/minimumJumps.jar"))))))
      (add-before
          'patch-usr-bin-file 'remove-script-env-flags
        (lambda* (#:key inputs #:allow-other-keys)
          (substitute*
              (find-files "./bin")
            (("#!/usr/bin/env -S guile \\\\\\\\")
             "#!/usr/bin/env guile \\")
            (("\"java")
             (string-append "\"" (search-input-file inputs "/bin/java"))))))
      (delete 'strip))))
  (native-inputs (list autoconf automake pkg-config texinfo
                       `(,openjdk17 "jdk")))
  (inputs (list guile-3.0-latest))
  (synopsis "Toy Repository for Code Challenge Solutions.")
  (description
   (string-append
    "Mostly just a repository of my solutions to various coding challenges, "
    "but also any tools I make along the way."))
  (home-page
   "https://github.com/yewscion/codechallenge-solutions")
  (license license:agpl3+))
