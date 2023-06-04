package study.thredaing;


//Method 1 Extends Thread

//Method 2 implement Runnable
public class ThreadBasicsRunner {
    /*
    Main is start

Task3 start

Task2 start
301 302 303 304 305 306 307 308 309 310 311 312 313 314 315 316 317 318 319 320 321 322 323 324 325 326 327 328 201 202 203 204 205 206 207 329 330 331 332 333 208 209 210 101 102 103 104 105 106 107 108 334 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 211 126 127 128 335 212 129 336 213 214 337 338 130 131 132 339 215 216 217 218 219 220 221 222 223 224 225 226 227 228 229 230 231 232 233 234 235 236 237 238 239 133 134 135 136 240 241 242 243 340 341 244 137 245 246 247 248 249 250 251 342 252 253 254 255 256 257 258 259 260 261 262 263 264 265 266 267 268 138 139 140 141 269 142 343 143 144 145 146 147 148 149 150 151 152 270 271 272 273 274 153 154 344 345 346 347 155 156 157 158 275 276 277 278 279 280 159 348 349 350 351 352 353 354 355 356 357 358 359 360 361 362 363 364 365 366 367 368 369 370 371 372 373 374 375 376 377 378 379 160 161 162 163 281 380 381 382 383 384 385 282 283 284 285 286 287 288 289 290 291 292 293 386 387 388 389 390 391 392 393 394 395 396 397 398
Task3 done

Main is done
164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181 182 183 184 185 186 187 188 189 190 191 192 193 194 195 196 197 198 294 295 296 297 298
Task2 done

Task1 done
*/

    /**
     * States of Thread
     * NEW - then thread is created
     * RUNNABLE - thred is runnable but waitng for CPU
     * RUNNING - itw working
     * BLOCKED/WAITING - blocked by some extrenal factor
     * TERMINATED/DEAD - enod of life for thread
     * @param args
     */

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nMain is start");

        //Task1
        Task1 task1 = new Task1();

        //Priority is nly recommendation, it may not be honoured always
        task1.setPriority(1);
        task1.start();
        //Task2
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(10);
        task2Thread.start();

        task1.join();
        task2Thread.join();
        //Task3
        System.out.println("\nTask3 start");
        for (int i = 301; i < 399; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask3 done");

        System.out.println("\nMain is done");
    }

}

class Task1 extends Thread {
    public void run() { //SIGNATUR
        System.out.println("\nTask1 started");
        for (int i = 101; i < 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask1 done");
    }

}

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("\nTask2 start");
        for (int i = 201; i < 299; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask2 done");
    }
}
