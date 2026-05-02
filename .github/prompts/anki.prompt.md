---
name: anki-prompt
description: "Create flashcards for English words with pronunciation and Portuguese translation"
type: prompt
---

# English Flashcard Creation Prompt

## 📝 Instructions to Create an English Flashcard

### Goal
Create a flashcard to help memorize and learn a new English word using spaced repetition (Anki).

---

### 📋 How to Use This Prompt

**When you want to create a new flashcard, provide a word like this:**
```
Create a flashcard for the word: [WORD]
```

**Note on Compound Words:** You can provide compound words (two or more words) such as:
- `Create a flashcard for the word: ice cream`
- `Create a flashcard for the word: social media`
- `Create a flashcard for the word: butterfly` (which is one word but counts as a compound concept)

Compound words will be formatted with spaces in the table for accurate sorting and storage.

---

### 🎯 What Will Be Generated

#### **Card Content:**

**Context (Memory side):** 
- A clear and meaningful English sentence demonstrating how to use the word in context
- The target word(s) should be <u>underlined</u> in the sentence for easy identification
- For compound words, underline all parts of the phrase (e.g., <u>ice cream</u>)
- Followed by pronunciation guide with [word] in brackets and IPA with Portuguese approximation
- Helps with memory associations and practical usage

**Definition (Translation side):**
- Word + Portuguese translation(s)

---

### 📊 Adding to the Anki Table

After creating the flashcard, the word(s) will be added to the table in alphabetic order by the `word` column.

**Important:** 
- Always maintain alphabetical sorting in the table to keep entries organized
- **NEVER add duplicate words** - check if the word already exists in the table before adding (exact match, including compound words)
- The table serves as the historical record of all created flashcards
- **For compound words:** Sort alphabetically by the first word, then by subsequent words (e.g., "ice cream" comes before "ice hockey")
- **IMPORTANT:** Only the current flashcard should be displayed in the file. Replace any previous flashcard with the new one. The table is the only section that accumulates all words.

| word | phonetic | translate |
|------|----------|-----------|
| butterfly | /ˈbʌtərflaɪ/ (ba-tê-flái) | borboleta |
| ice cream | /aɪs kriːm/ (ais crím) | sorvete |

---

## 🚀 Ready to Start?

**Simply provide an English word you'd like to learn**, and follow this format:

1. Context phrase with word underlined
2. Pronunciation guide (IPA + Portuguese approximation)
3. Portuguese translation
4. Add to table in alphabetical order (if not already present)

**Output Format:**

**Context phrase:**
> [Meaningful English sentence with <u>word</u> underlined]
>
> <br>
>
> [word] - /IPA pronunciation/ <-> (Portuguese speaker approximation)

**Definition:**
> [word] - Portuguese translation

**Table Entry (only if word is NEW):**
| word | phonetic | translate |
|------|----------|-----------|
| word | /IPA/ (translation) | Portuguese translation |

**Table Entry (only if word is NEW):**
| word | phonetic | translate |
|------|----------|-----------|
| word | /IPA/ (translation) | Portuguese translation |

---

## 💡 Tips for Better Learning

- Focus on common, practical words (single or compound)
- Create examples from real-life contexts
- Say the pronunciation aloud to improve accent
- Review cards regularly with Anki
- Keep the Anki table sorted alphabetically for easy navigation
- **For compound words:** Remember to treat them as a single unit for sorting purposes (e.g., "social media" is treated as one entry)
- **Compound word handling:** When a phrase has multiple words, use underlines on all parts to emphasize they form a single concept

---

**Example:**

**Input:** "Create a flashcard for the word: elephant"

**Output:**

> I saw a huge <u>elephant</u> at the zoo, walking slowly through the savanna.
>
> <br>
>
> [elephant] - /ˈɛlɪfənt/ <-> (é-li-fante)

> [elephant] - elefante

**Table Update (if elephant is NEW):**
| word | phonetic | translate |
|------|----------|-----------|
| elephant | /ˈɛlɪfənt/ (é-li-fante) | elefante |

---

**Example with Compound Word:**

**Input:** "Create a flashcard for the word: ice cream"

**Output:**

> On a hot summer day, I enjoyed a delicious bowl of <u>ice cream</u> at the dessert shop.
>
> <br>
>
> [ice cream] - /aɪs kriːm/ <-> (ais crím)

> [ice cream] - sorvete

**Table Update (if ice cream is NEW):**
| word | phonetic | translate |
|------|----------|-----------|
| ice cream | /aɪs kriːm/ (ais crím) | sorvete |

*Note: If the word already exists in the table, do NOT add it again.*

