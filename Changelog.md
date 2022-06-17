# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this projectadheres to [Semantic
Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- Nothing

### Changed
- Nothing

### Removed
- Nothing

## [0.0.1]
### Added
- Initial Project Files.
- Java Implementation of "Minimum Jumps" Challenge.
- `Challenges.md`, which is where I will archive the challenges I work on.
- Documentation of repository and user-facing programs.
- Guile Implementation of AoC 2021 Day One Challenge P1 and P2.
- `sonar-sweep` program.
- `minimumJumps-java` program

### Changed
- Various minor changes to templates.
- `guix.scm` now uses `local-file` to load the tarball.
- For Java Code, package scheme is now `codechallenges.<challenge>`. May revisit
  at some point.
- Autotools for both Scheme and Java should work now.
- `src/` is now named `codechallenges/` to fit with Guile Module naming scheme.

### Removed
- Unneeded temporary files from git repo.

[0.0.1]: https://github.com/yewscion/codechallenge-solutions/releases/tag/v0.0.1/
[Unreleased]: https://github.com/yewscion/codechallenge-solutions/commit/trunk

<!-- Local Variables: -->
<!-- mode: markdown -->
<!-- coding: utf-8-unix -->
<!-- End: -->
