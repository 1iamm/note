> General-Purpose Registers (GPR) - 16-bit naming conventions

1. Accumulator register (AX). Used in arithmetic operations
2. Counter register (CX). Used in shift/rotate instructions and loops.
3. Data register (DX). Used in arithmetic operations and I/O operations.
4. Base register (BX). Used as a pointer to data (located in segment register DS, when in segmented mode).
5. Stack Pointer register (SP). Pointer to the top of the stack.
6. Stack Base Pointer register (BP). Used to point to the base of the stack.
7. Source Index register (SI). Used as a pointer to a source in stream operations.
8. Destination Index register (DI). Used as a pointer to a destination in stream operations.

![image-20211227165627200](https://s2.loli.net/2021/12/27/5cAUrkTYfzndQHX.png)



> segment registers

1. Stack Segment (SS). Pointer to the stack ('S' stands for 'Stack').

2. Code Segment (CS). Pointer to the code ('C' stands for 'Code').

3. Data Segment (DS). Pointer to the data ('D' comes after 'C').

4. Extra Segment (ES). Pointer to extra data ('E' stands for 'Extra').

5. F Segment (FS). Pointer to more extra data ('F' comes after 'E').

6. G Segment (GS). Pointer to still more extra data ('G' comes after 'F').

![image-20211227165926505](https://s2.loli.net/2021/12/27/HACOhGs23BWvQZp.png)=
