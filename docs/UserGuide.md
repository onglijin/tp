---
layout: page
title: User Guide
---

Ace 2103/T is a **desktop app for managing task requirements of CS2103/T, optimized for use via Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Ace 2103/T can get your learning tasks managed faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your Ace 2103/T.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`**`6` : Lists all tasks for week 6.

   * **`deadline`**`0601 15-09-2020 23:59` : Adds a deadline 15-09-2020 23:59 to task indexed at 0601.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `list WEEK_NUMBER`, `WEEK_NUMBER` is a parameter which can be used as `list 6`.

* Items in square brackets are optional.<br>
  e.g `help [PARAMETER]` can be used as `help find` or as `help`.

</div>

### Viewing help: `help`

Lists all available commands or format and usage for a specified command.

Format: `help [PARAMETER]`

List of PARAMETERs :

* No parameters: List all the supported commands for the task manager.
* get: `get [PARAMETER]`. Gets specified administrative information by parameters.
* find: `find KEYWORD`. Lists all tasks that contain the keyword.
* list: `list WEEK_NUMBER`. Lists all tasks in a specific week.
* deadline: `deadline TASK_NUMBER DEADLINE`. Adds a customized deadline to a preloaded task.
* add: `add DESCRIPTION DEADLINE [REMARKS]`. Adds a customized task in the task manager.
* delete: `delete TASK_NUMBER`. Deletes a customized task in the task manager.
* exit: `exit`. Exits the task manager.

### Viewing administrative information: `get`
    
Gets specified administrative information by parameters.
    
Format: `get [PARAMETER]`
    
List of PARAMETERs :

* contact: Returns the email addresses of professors and TAs in charge of CS2103/T.
* faq: Returns preloaded FAQs on CS2103/T.
* overview: Returns the preloaded module overview.
* progress: Returns the links to iP and tP progress dashboards.
* setup: Returns the preloaded instructions about how to set up Github, IntelliJ and SourceTree.
* tp: Returns the team project Github link if it is available. Otherwise, user is prompted to key in the link.

### Finding relevant tasks: `find`

Lists all tasks that contain the keyword.

Format: `find KEYWORD`

* The KEYWORD is a letter string in the description of tasks to be returned.
* Operates rough search in the task list.

Example:
* `find book`: Returns all tasks containing “book” in their descriptions.

### List tasks: `list`

Lists all tasks in a specific week.

Format: `list WEEK_NUMBER`

* The WEEK_NUMBER is a digit representing a teaching week.

Example:
* `list 6`: Returns all tasks in teaching week 6.

### Deleting a customized task: `delete`

Deletes a customized task in the task manager.

Format: `delete TASK_NUMBER`

* The task indexed at TASK_NUMBER will be deleted.

Example:
* `delete 0601`: Task indexed at 0601 will be deleted.

### Adding a deadline: `deadline`

Adds a customized deadline to a preloaded task.

Format: `deadline TASK_NUMBER DEADLINE`

* The task indexed at TASK_NUMBER will be given a DEADLINE.

Example:
* `deadline 0601 15-09-2020 23:59`: Adds a customized deadline of 23:59 on 15th September 2020 to the first task of teaching week 6 which is indexed at TASK_NUMBER 0601.

### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Deadline** | `deadline TASK_NUMBER DEADLINE` <br> e.g., `deadline 0601 15-09-2020 23:59`
**Delete** | `delete TASK_NUMBER`<br> e.g., `delete 0601`
**Exit** | `exit`
**Find** | `find KEYWORD`<br> e.g., `find book`
**Get**  | `get [PARAMETER]`
**Help** | `help [PARAMETER]`
**List** | `list WEEK_NUMBER` <br> e.g., `list 6`
