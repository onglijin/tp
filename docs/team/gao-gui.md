---
layout: page
title: Gao Gui's Project Portfolio Page
---

## Project: Ace CS2103/T

Ace CS2103/T is a desktop task manager application used for keeping track of tasks for CS2103/T Software Engineering. The user interacts with it using a CLI, and it has a GUI created with JavaFX.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense_link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=onglijin&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **Refactoring**: Refactored the code to introduce new classes for all components of Task under Model.
    * What it does: Allows each component of task to have its own class
    * Justification: This allows test code to be written in a way that each component can be tested independently and for the behaviour of the component to be contained within the class and be unknown to the public.
    * Highlights: This enhancement affects the Task class and all existing commands and commands to be added in the future. It required an in-depth analysis of the existing code. The implementation was challenging as it required changes to most of the exisitng files.

* **UI components**: In charge of most UI components including creation, bug shooting, maintenance, etc.
    * Justification: The UI components are important in a project as it will affect user experience
    * Category box: To show the category label for each panel [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/75
	* Category panel: To display all the tasks that belong to the specific week and corresponding categories. [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/75
	* Task box: To display necessary information such as description, deadline, remark, etc. for a task [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/75
	* Feedback box: Allow users to see the status (success or fail) for a command [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/141

* **UI design**: In charge of design for UI components.
    * Justification: The design of UI will have a huge influence on the first impression of users on the application.
	* Example of related pull requests: [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/97  [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/103  [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/159
	
* **Testing code**: Participate in wirting testing code.
    * Justification: Testing code can help to find out bugs in the application.
	* Example of related pull requests: [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/232
	
* **Documentation**:
  * User Guide:
    * Added documentation for the features `help` `add` [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/11
    * Updated Ui picture of the application 

  * Developer Guide:
    * Add Help instruction and Non-functional requirements [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/32
	* Updated the implmented and ongoing Ui enhancement in the deleloper guide: [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/131

* **Contributions to team-based tasks**:
  * Review/mentoring contributions: [\#5]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/146, [\#013]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/138, [\#131]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/105 [\#131]https://github.com/AY2021S1-CS2103-T14-4/tp/pull/104
  * Contributions beyond the project team: 
    * Helping others: [\#5]https://github.com/nus-cs2103-AY2021S1/forum/issues/108 [\#5]https://github.com/nus-cs2103-AY2021S1/forum/issues/147 [\#5]https://github.com/nus-cs2103-AY2021S1/forum/issues/86
    * Technical Leadership: [\#5]https://github.com/nus-cs2103-AY2021S1/forum/issues/5 [\#5]https://github.com/nus-cs2103-AY2021S1/forum/issues/149 
