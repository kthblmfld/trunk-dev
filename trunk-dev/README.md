Trunk-Dev
========

TL:DR of [Trunk-based Development](https://trunkbaseddevelopment.com/)

Gitflow is the path towards long-lived branches. Long-lived branches are the path towards merge hell. Developers do not
want to end up in merge hell.

Commits should be small and frequent. Code reviews should be eager and continuous. 

Small teams can commit directly to trunk. Larger teams can to pull requests using short-lived branches.

Longer/larger features are to use feature toggles and 
[abstract branches](https://trunkbaseddevelopment.com/branch-by-abstraction/)

* Wrap existing feature in abstraction
* Replace existing feature with new feature
* Toggle between features, never break the build

