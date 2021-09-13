# Design Principles and Design Patterns by Robert C. Martin (2000)

## Symptoms of Rotting Design 

- Rigidity
    - difficult to change, every change causes a cascade of subsequent changes in dependent modules
- Fragility
    - tendency of the software to break in many places every time it's changed
- Immobility
    - inability to reuse software from other projects or from parts of the same project
- Viscosity
    - viscosity of design
        - hard to change while preserving the design, the 'hack' is easier to employ
    - viscosity of environment
        - inefficient development environment, long compile times, engineers may choose to make changes that don't force recompiles even though that may not preserve the design

***The four symptons metioned above is either directly, or indirectly caused by improper dependencies between the modules of the software. It is the dependency architecture that is degrading, and with it the ability of the software to be maintained.***

## SOLID Principles:

- Single Responsibility Principle
    - ***A software component must have only one responsibility.***
- Open/Closed Principle
    - ***A module should be open for extension but closed for modification***
    - Abstraction && Polymorphism are the key to the OCP
    - Try to implement things in the way that the change of behaviours are up to the implementation
    - If you don't change the working code, then you aren't likely to break it
- Liskov Substitution Principle
    - ***Subclasses should be substitutable for their base classes***
    - User of the base class should continue to function properly if the base class are replaced with subclasses
    - It's drives from the concept of **Design by Contract**
    - A derived class is substitutable for its base class if:
        - Its preconditions are no stronger than the base class method
        - Its postconditions are no weaker than the base class method
    - **Derived methods should expect no more and provide no less**
- Interface Segregation Principle
    - ***Many client specific interfaces are better thant one general purpose interface***
    - If a client needs lots of functionalities, instead of having a large interface with all these methods, create lots of smaller and more specific interfaces and inherit them for this client.
- Dependency Inversion Principle
    - ***Depend upon Abstractions. Do not depend upon concretions.***
    - The general idea is that concrete things change a lot, abstract things change must less frequently. 
    - In case where object creation must depend on concretions, we can use **Abstract Factory**.

## Principles of Package Architecture

### Package Cohesion Principles 

***These three principles are mutually exclusive, they cannot simultaneously be satisfied. REP and CRP are for resuers, and CCP is for maintainers.*** CCP tries to make package as large as possible, while the CRP tries to make packages as small as possible.

- REP - Release Reuse Equivalence Principle
    - ***The granule of reuse is the granule of release***
    - Group elements that are reusable together 
- CCP - Common Closure Principle
    - ***Classes that change together, belong together***
- CRP - Common Reuse Principle
    - ***Classes that aren't reused together should not be grouped together***

### Package Coupling Principles

- ADP - Acyclic Dependencies Principle
    - ***The dependencies between packages must not form cycles***
    - Cycles can be broken using dependency inversion, add new layer of abstraction, and all relevant components depend on the abstraction, the concretions is then freed.
    - Say we have package {A, B} and package {X, Y}, if A depends on X, and Y depends on B, there is a cycle between these two packages. We can then introduce an interface BY in {X, Y}, then we make Y depend on BY, and B implements BY. This way we inverted the dependency changing Y->B to B->BY<-Y, and the packages become {A, B} and {X, Y, BY}.
- SDP - Stable Dependencies Principle
    - ***Depend in the direction of stability***
    - Stability is not frequency of change.
    - Stability is related to the amount of work required to make a change.
    - Direction of dependencies should point towards more stable components.
    - The components that are designed to be flexible should not be pointed by **stable** packages.
- SAP - Stable Abstraction Principle
    - ***Stable packages should be abstract packages***
    - The package structure can be imagined as the instable packages at the top and the stable packages on the bottom, this way all dependencies point downwards.
    - This pattern correlates with the DIP, depends on abstraction not concretions.
